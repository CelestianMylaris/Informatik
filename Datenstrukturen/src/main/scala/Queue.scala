package queue
import liste.Liste
abstract class Queue[A]:
  def dequeue(): Option[A]
  def enqueue(x: A): Unit
  def front: Option[A]
  def isEmpty: Boolean
  def size: Int

class QML[A] extends Queue[A]:
  val liste = Liste[A]()

  override def size: Int = liste.size

  override def enqueue(x: A): Unit = liste.append(x)

  override def dequeue(): Option[A] =
    val temp = liste.get(0)
    liste.removeAt(0)
    temp

  override def front: Option[A] = liste.get(0)

  override def isEmpty: Boolean = liste.isEmpty
