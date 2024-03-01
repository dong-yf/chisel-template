cd firrtl
sbt "publishLocal"
cd ..
# sbt "testOnly gcd.DecoupledGCDFormalSpec"
sbt "testOnly testCHA.gcd.DecoupledGcdSpec"