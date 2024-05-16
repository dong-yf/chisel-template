cd chiseltest
sbt "publishLocal"
cd ..
# sbt "testOnly gcd.DecoupledGCDFormalSpec"
sbt "testOnly example.xiangshan.DividerFormalSpec"