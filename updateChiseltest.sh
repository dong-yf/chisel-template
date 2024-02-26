cd chiseltest
sbt "publishLocal"
cd ..
sbt "testOnly gcd.DecoupledGCDFormalSpec"