import collection.mutable.Stack
import org.scalatest._
import Matchers._

class StackSpec extends FlatSpec {
  "simple assert" should "work" in {
    assert(1 === 1)
  }

  "should concat lists correctly" should "be right" in {
    val list1 = List(1)
    val list2 = List(2)
    val combined = list1 ::: list2
    assert(combined.equals(List(1, 2)))
  }

  "map concat" should "be correct" in {
    var map1: Map[Int, Int] = Map(1 -> 2)
    val map2: Map[Int, Int] = Map(3 -> 4)
    map1 ++= map2
    assert(map1 === Map(1 -> 2, 3 -> 4))
  }

  "cut pieces" should "work" in {
    try {
      Pieces.cutPiece(5, 6) == List(5)
    } catch {
      case e: Exception => e.getMessage shouldEqual "5 was not greater than 6"
    }

    try {
      Pieces.cutPiece(6, 6)
    } catch {
      case e: Exception => e.getMessage shouldEqual "6 was not greater than 6"
    }
    assert(Pieces.cutPiece(7, 6) == List(1, 6))
  }

  "hash list" should "work" in {
    assert(Pieces.getPiecesHash(List(1, 2, 3)) === "1-2-3")
  }

  "cutting into pieces" should "be simple" in {
    assert(true)
  }
}

object Pieces {
  def cutRod(pieces: List[Long], cutLengths: List[Long]): Unit = {
    for (pieceLength <- pieces) {
      for (cutSize <- cutLengths) {
        if (pieceLength > cutSize) {
          cutRod(pieces ::: cutPiece(pieceLength, cutSize), cutLengths)
        }
      }
    }
  }
  def cutPiece(pieceLength: Long, cutSize: Long): List[Long] = {
    assert(pieceLength > cutSize)
    val piece1Length = pieceLength - cutSize
    val piece2Length = cutSize
    return List(piece1Length, piece2Length)
    return List(pieceLength)
  }
  def getPiecesHash(pieces: List[Long]): String = {
    pieces mkString "-"
  }
}
