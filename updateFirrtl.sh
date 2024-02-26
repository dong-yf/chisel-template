cd firrtl
sbt "publishLocal"
cd ..
sbt "testOnly gcd.DecoupledGCDFormalSpec"