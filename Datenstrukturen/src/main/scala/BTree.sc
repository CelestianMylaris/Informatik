object BTree:
  def preOrder[A](baum: BTree[A], action: A => Unit): Unit =
    if baum == null then return
    action(baum.inhalt)
    preOrder(baum.links, action)
    preOrder(baum.rechts, action)

  def postOrder[A](baum: BTree[A], action: A => Unit): Unit =
    if baum == null then return
    postOrder(baum.links, action)
    postOrder(baum.rechts, action)
    action(baum.inhalt)
    

  def size[A](baum: BTree[A]): Int =
    if baum == null then 0
    else 1 + size(baum.links) + size(baum.rechts)

  def hoehe[A](akt: BTree[A], counter: Int): Int =
    if akt.links == null && akt.rechts == null then return counter
    if akt.rechts == null then return hoehe(akt.links, counter + 1)
    if akt.links == null then return hoehe(akt.rechts, counter + 1)
    val hl = hoehe(akt.links, counter + 1)
    val hr = hoehe(akt.rechts, counter + 1)
    if hl > hr then hl else hr

  def groesse[A](akt: BTree[A], counter: Int): Int =
    if akt == null then return counter
    val cl = groesse(akt.links, counter)
    val cr = groesse(akt.rechts, counter)
    cl + cr + 1

  def contains[A](wert: A, akt: BTree[A]): Boolean =
    if akt == null then return false
    if akt.inhalt == wert then return true
    contains(wert, akt.links) || contains(wert, akt.rechts)

class BTree[A](var inhalt: A, var links: BTree[A] = null , var rechts: BTree[A] = null):
  def preOrder(action: A => Unit): Unit =
    BTree.preOrder(this, action)

  def size: Int =
    BTree.size(this)

  def hoehe: Int =
    BTree.hoehe(this, 0)

  def groesse: Int =
    BTree.groesse(this, 0)

  def contains(wert: A): Boolean =
    BTree.contains(wert, this)
val lb: BTree[Int] = null
val baum = BTree(
  1,
  BTree(2, BTree(3), BTree(4)),
  BTree(4)
)

val btl = BTree(
  1,
  BTree(
    2,
    BTree(
      3
    )
  )
)

val btr = BTree(
  1,
  null,
  BTree(
    2,
    null,
    BTree(
      3
    )
  )
)


BTree.preOrder(baum, println)
BTree.preOrder(lb, println(_))
BTree.preOrder(baum, i => println(i + ","))

