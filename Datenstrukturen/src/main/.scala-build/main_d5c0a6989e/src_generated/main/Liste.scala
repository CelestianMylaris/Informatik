

final class Liste$_ {
def args = Liste_sc.args$
def scriptPath = """Liste.sc"""
/*<script>*/
case class Listenknoten[A](var inhalt: A, var next: Listenknoten[A])

case class Liste[A]():
  private var kopf: Listenknoten[A] = null
  var length = 0

  def isEmpty: Boolean = if kopf == null then true else false
  def insertAtR(index: Int,element: A, stelle: Listenknoten[A] = kopf, zaehler: Int = 0): Unit =
    if zaehler == index then
      stelle.next = Listenknoten[A](element, stelle.next)
      return
    else if stelle == null then return

    else
      insertAtR(index,element,stelle.next, zaehler+1)


  def insertAt(index: Int, element: A): Unit =
    val neuerKnoten = new Listenknoten[A](element, null)
    if index == 0 then
      neuerKnoten.next = kopf
      kopf = neuerKnoten
    else
      var aktuell = kopf
      var zehler = 0
      while aktuell != null && zehler < index - 1 do
        aktuell = aktuell.next
        zehler += 1
      neuerKnoten.next = aktuell.next
      aktuell.next = neuerKnoten
    length += 1

  def insert( element: A): Unit =
    val neuerKnoten = new Listenknoten[A](element, null)
    neuerKnoten.next = kopf
    kopf = neuerKnoten
    println(neuerKnoten)
    length += 1



  def clear(): Unit =
    kopf = null
    length = 0



  def contains(element: A): Boolean =
    var stelle = kopf
    while stelle != null do
      if stelle.inhalt == element then return true
      stelle = stelle.next
    false

  def get(at: Int): Option[A] =
    var stelle = kopf
    var idx = 0
    while stelle != null do
      if idx == at then return Some(stelle.inhalt)
      stelle = stelle.next
      idx += 1

    None




  def locate(e: A): Int =
    var stelle = kopf
    var index = 0
    while stelle != null do
      if stelle.inhalt == e then
        return index
      else
        stelle = stelle.next
        index += 1
    -1

  def size: Int =
    var stelle = kopf
    var index = 0
    while stelle != null do
      stelle = stelle.next
      index += 1
    index

  private def getLK(at: Int): Listenknoten[A] =
    var stelle = kopf
    var idx = 0
    while stelle != null do
      if idx == at then return stelle
      idx += 1
      stelle = stelle.next
    null


  private def vorgaengerVon(e: A): Listenknoten[A]=
    getLK(this.locate(e) - 1)

  override def toString: String =
    var out = "List("
    var stelle = kopf
    while stelle != null do
      if stelle.next == null then
        out = out + s"${stelle.inhalt}"
      else
        out = out + s"${stelle.inhalt},"

      stelle = stelle.next
    out + ")"


  def removeAt(idx: Int): Unit =
    if idx == 0 then
      kopf = kopf.next
    else
      getLK(idx-1).next = getLK(idx + 1)
    length -= 1

  def remove(e: A):Unit =
    val idx = locate(e)
    removeAt(idx)

  def append(e: A): Unit =
    insertAt(length, e)

  def exists(f: A => Boolean): Boolean =
    var stelle = kopf
    while stelle != null do
      if f(stelle.inhalt) then return true
      stelle = stelle.next
    false

  def forAll(f: A => Boolean): Boolean =
    var stelle = kopf
    while stelle != null do
      if !f(stelle.inhalt) then return false
      stelle = stelle.next
    true

  def foreach(f: A => Unit): Unit =
    var stelle = kopf
    while stelle != null do
      f(stelle.inhalt)
      stelle = stelle.next

  def filter(f: A => Boolean): Liste[A] =
    val liste = new Liste[A]()
    var stelle = kopf
    while stelle != null do
      if f(stelle.inhalt) then liste.append(stelle.inhalt)
      stelle = stelle.next
    liste

  def map[B](f: A => B): Liste[B] =
    val liste = new Liste[B]()
    var stelle = kopf
    while stelle != null do
      liste.insert(f(stelle.inhalt))
      stelle = stelle.next

    liste

object Liste:
  def apply[A](all: A*) =
    val liste = new Liste[A]
    for e <- all do
      liste.append(e)

    liste

val lcrack = Liste(1,2,3,4,5,6,7,8,9,0)




val l1 = Liste[Int]()
l1.insert(1)
l1.insert(2)
l1.insert(3)
assert(l1.toString == "List(3,2,1)")
assert(l1.contains(2))
assert(l1.locate(1) == 2)
assert(l1.length == 3 && l1.size == 3)
l1.removeAt(1)
assert(l1.toString == "List(3,1)")
l1.insertAt(2,4)
assert(l1.toString == "List(3,1,4)")
l1.append(5)
assert(l1.toString == "List(3,1,4,5)")
assert(!l1.isEmpty)

// Sonderfälle
val l2 = Liste[Int]()
assert(l2.isEmpty)
assert(!l2.contains(1))
assert(l2.locate(1) == -1)
l2.append(77)
assert(l2.toString == "List(77)")
l2.remove(77)
assert(l2.isEmpty)

l2.exists(_ > 1)
l2.forAll(_ > 47)
l2.foreach(println)
l2.filter(_ > 1)
l2.map(_*2).toString

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

  override def push(e:A): Unit =
    array(length) = e
    length += 1

  override def pop(): Option[A] =
    if length == 0 then return None
    length -= 1
    Some(array(length).asInstanceOf[A])

  override def top: Option[A] = Some(array(length-1).asInstanceOf[A])

  override def isEmpty: Boolean = length == 0


val sml1: Stack[Int] = SML[Int]()


sml1.top
assert(sml1.isEmpty)
sml1.push(69)
sml1.push(420)
sml1.push(187)

assert(sml1.top == Some(187))


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




/*</script>*/ /*<generated>*//*</generated>*/
}

object Liste_sc {
  private var args$opt0 = Option.empty[Array[String]]
  def args$set(args: Array[String]): Unit = {
    args$opt0 = Some(args)
  }
  def args$opt: Option[Array[String]] = args$opt0
  def args$: Array[String] = args$opt.getOrElse {
    sys.error("No arguments passed to this script")
  }

  lazy val script = new Liste$_

  def main(args: Array[String]): Unit = {
    args$set(args)
    val _ = script.hashCode() // hashCode to clear scalac warning about pure expression in statement position
  }
}

export Liste_sc.script as `Liste`

