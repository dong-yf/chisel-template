## Z3 优化

考虑两方面的优化，存储branch var的数据结构和设计对应branch var的启发式算法

### 优化数据结构

#### u_map结构

##### u_map API

* size()
* empty()
* erase()
* begin()