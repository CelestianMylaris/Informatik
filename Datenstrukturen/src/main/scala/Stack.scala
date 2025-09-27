package stack
import liste.Liste

abstract class Stack[A]:
  def pop(): Option[A]
  def push(x: A): Unit
  def top: Option[A]
  def isEmpty: Boolean
  def size: Int

class SML[A] extends Stack[A]:
  val liste = Liste[A]()
  override def push(x: A): Unit = liste.insert(x)

  override def pop(): Option[A] =
    val temp = liste.get(0)
    liste.removeAt(0)
    temp

  override def top: Option[A] = liste.get(0)

  override def isEmpty: Boolean = liste.isEmpty

  override def size: Int = liste.length

class SMA[A] extends Stack[A]:
  val array: Array[Any] = Array.ofDim(1000)
  var length = 0

  override def size: Int = length

  override def push(e: A): Unit =
    array(length) = e
    length += 1

  override def pop(): Option[A] =
    if length == 0 then return None
    length -= 1
    Some(array(length).asInstanceOf[A])

  override def top: Option[A] = Some(array(length - 1).asInstanceOf[A])

  override def isEmpty: Boolean = length == 0
