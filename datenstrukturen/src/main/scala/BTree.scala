package btree
class BTree[A](initial: A) {
  var inhalt: A = initial
  var links: BTree[A] = null
  var rechts: BTree[A] = null

  def hoehe: Int =
    hoeheH(this, 0)

  private def hoeheH(akt: BTree[A], counter: Int): Int =
    if akt.links == null && akt.rechts == null then return counter
    if akt.rechts == null then return hoeheH(akt.links, counter + 1)
    if akt.links == null then return hoeheH(akt.rechts, counter + 1)
    val hl = hoeheH(akt.links, counter + 1)
    val hr = hoeheH(akt.rechts, counter + 1)
    if hl > hr then hl else hr

  def groesse: Int =
    groesseH(this, 0)
  private def groesseH(akt: BTree[A], counter: Int): Int =
    if akt == null then return counter
    val cl = groesseH(akt.links, counter)
    val cr = groesseH(akt.rechts, counter)
    cl + cr + 1

  def contains(suche: A): Boolean =
    if inhalt == suche then return true
    val cl = if links != null then links.contains(suche) else false
    val cr = if rechts != null then rechts.contains(suche) else false
    cl || cr
}
