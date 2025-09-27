package liste
case class Listenknoten[A](var inhalt: A, var next: Listenknoten[A])

case class Liste[A]():
  private var kopf: Listenknoten[A] = null
  var length = 0

  def isEmpty: Boolean = if kopf == null then true else false
  def insertAtR(
      index: Int,
      element: A,
      stelle: Listenknoten[A] = kopf,
      zaehler: Int = 0
  ): Unit =
    if zaehler == index then
      stelle.next = Listenknoten[A](element, stelle.next)
      return
    else if stelle == null then return
    else insertAtR(index, element, stelle.next, zaehler + 1)

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

  def insert(element: A): Unit =
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
      if stelle.inhalt == e then return index
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

  private def vorgaengerVon(e: A): Listenknoten[A] =
    getLK(this.locate(e) - 1)

  override def toString: String =
    var out = "List("
    var stelle = kopf
    while stelle != null do
      if stelle.next == null then out = out + s"${stelle.inhalt}"
      else out = out + s"${stelle.inhalt},"

      stelle = stelle.next
    out + ")"

  def removeAt(idx: Int): Unit =
    if idx == 0 then kopf = kopf.next
    else getLK(idx - 1).next = getLK(idx + 1)
    length -= 1

  def remove(e: A): Unit =
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
    for e <- all do liste.append(e)

    liste
