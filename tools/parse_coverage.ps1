$csvPath = Join-Path (Get-Location) 'target\site\jacoco\jacoco.csv'
if (-not (Test-Path $csvPath)) {
  Write-Error "Coverage CSV not found at $csvPath"
  exit 2
}
$csv = Import-Csv $csvPath
$threshold = 50
$results = @()
foreach ($r in $csv) {
  $miss = [int]$r.LINE_MISSED
  $cov = [int]$r.LINE_COVERED
  $total = $miss + $cov
  if ($total -eq 0) { $pct=0 } else { $pct = [math]::Round(($cov/$total)*100,2) }
  if ($pct -lt $threshold) {
    $results += [PSCustomObject]@{Class=$r.CLASS;Package=$r.PACKAGE;Group=$r.GROUP;Pct=$pct;Covered=$cov;Missed=$miss}
  }
}
if ($results.Count -eq 0) { Write-Output "No classes under $threshold% coverage."; exit 0 }
$results | Sort-Object Pct | Format-Table -AutoSize
