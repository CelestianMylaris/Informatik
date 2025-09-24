class BTree[A](initial: A):
  var inhalt: A = initial
  var links: BTree[A] = null
  var rechts: BTree[A] = null

  def  hoehe: Int = 
    hoeheH(this, 0)
  
  private def hoeheH(akt: BTree[A], counter: Int) = 
    if akt.links == null && akt.rechts == null then return counter
    if akt.rechts == null then return hoeheH(akt.links)
    if akt.links == null then return hoeheH(akt.rechts)

