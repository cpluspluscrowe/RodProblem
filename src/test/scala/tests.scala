import collection.mutable.Stack
import org.scalatest._

class StackSpec extends FlatSpec {
  "simple assert" should "work" in {
    assert(1 === 1)
  }

  "should concat lists correctly" should "be right" in {
    val list1 = List(1)
    val list2 = List(2)
    val combined = list1 ::: list2
   assert(combined.equals(List(1,2)))
  }

  "map concat" should "be correct" in {
    var map1:Map[Int, Int] = Map(1 -> 2)
    val map2: Map[Int, Int] = Map(3 -> 4)
    map1 ++= map2
    assert(map1 === Map(1 -> 2, 3 -> 4))

  }

}
