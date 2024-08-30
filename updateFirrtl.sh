set -e
cd firrtl
sbt "publishLocal"
cd ..
sbt "testOnly example.Example112FormalSpec"
# sbt "testOnly nutcore.CacheFormalSpec"
# sbt "testOnly nutcore.CacheStage3FormalSpec" 
# sbt "testOnly newtemplate.Template01nFormalSpec"
# sbt "testOnly examples.ArbiterFormalSpec"
# sbt "testOnly example.rocketchip.DivFormalSpec"
# sbt "testOnly example.rocketchip.MulFormalSpec"
# sbt "testOnly template.Template31FormalSpec"
# sbt "testOnly examples.heappriorityqueue.modules.LinearSearchMemFormalSpec"
# sbt "testOnly gcd.DecoupledGCDFormalSpec"
# sbt "testOnly formal.NutCoreFormalSpec"
# sbt "testOnly example.xiangshan.DividerFormalSpec"
# sbt "testOnly mini.RISCVMiNiFormalSpec"