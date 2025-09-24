// Berechnet die Fakultät von n, also das Produkt
// n! =  1*2*3*...*(n-1)*n
def fakultaet(n: Int): Int =
  // Basisfall
  if (n == 0) return 1
  //  rekursiver Aufruf / einfacher und kleiner/ n*(n-1)!
  fakultaet(n-1) *n





assert(fakultaet(0) == 1)
assert(fakultaet(1) == 1)
assert(fakultaet(2) == 2)
assert(fakultaet(3) == 6)
assert(fakultaet(5) == 120)


// Ermittelt, ob der Parameter "text" ein Palindrom ist,
// d.h. rückwärts gelesen gleich aussieht (z.B. "ANNA" oder "RENTNER").
def istPalindrom(text: String): Boolean =
  // Basisfall
  if (text.length<=1) return true
  if (text(0) != text(text.length-1)) return false
  // Rekursive
  else
    istPalindrom(text.substring(1,text.length-1))


// Tipp: text(0), text.last, text.substring(1, text.length -1)

assert(istPalindrom(""))
assert(istPalindrom("a"))
assert(istPalindrom("aa"))
assert(istPalindrom("aaa"))
assert(istPalindrom("ANNA"))
assert(istPalindrom("RENTNER"))
assert(istPalindrom("12") == false)
assert(istPalindrom("1ABBA2") == false)
assert(istPalindrom("ABCA") == false)
assert(istPalindrom("ABCDDBA") == false)



def hanoi(anz: Int, von: String, nach: String, zwsp: String): Unit =
  if anz != 0 then
    hanoi((anz-1),von,zwsp,nach)
    println("von "+ von+ " nach "+ nach)


hanoi(2, "Start", "Ziel", "Zwischenspeicher")
hanoi(3, "links", "mitte", "rechts")

def mergesort(arr: Array[Int],von: Int,rRdlH: Int,bis: Int): Unit =
  val arrcopie = Array.ofDim[Int](bis-von+1)
  var tmpIdx=0
  var linkerIdx=von
  var rechterIdx=rRdlH+1
  // beide Arrays enthalten Werte?
  while linkerIdx<=rRdlH && rechterIdx<=bis do
    // wenn rechts größer dann copiere rechts raus
    if arr(linkerIdx)<arr(rechterIdx) then
      arrcopie(tmpIdx) = arr(linkerIdx)
      tmpIdx+=1
      linkerIdx+=1
      // wenn links größer dann kopiere links raus
    else if arr(rechterIdx)<arr(linkerIdx) then
      arrcopie(tmpIdx)=arr(rechterIdx)
      tmpIdx+=1
      rechterIdx+=1
  // wenn linke hälfte leer dann kopiere rechts komplet
  // in gleicher Reihenfolge raus
  while linkerIdx > rRdlH && rechterIdx <= bis do
    arrcopie(tmpIdx)=arr(rechterIdx)
    tmpIdx+=1
    rechterIdx+=1
  // wenn rechte hälfte leer dann kopiere links komplet
  // in gleicher Reihenfolge raus
  while rechterIdx>bis && linkerIdx <= rRdlH do
    arrcopie(tmpIdx)=arr(linkerIdx)
    tmpIdx+=1
    linkerIdx+=1
  // wenn fertig sortiert dann füge copierten arr wieder
  // in urschbrünglichen ein
  var EinZuFügStelleImArr = von
  for EinZuFügStelleInCopie <- 0 to arrcopie.length-1 do
    arr(EinZuFügStelleImArr) = arrcopie(EinZuFügStelleInCopie)
    EinZuFügStelleImArr += 1


//mergesort(-10;8;12;19;6;12;55;56;56,0,3,8) == Array(-10;6;8;12;12;19;55;56;56)
var TestArr = Array(-10,-6,-3,20,-8,3,55,56,56)
var TestArr2 = Array(-10,-6,-3,20,-8,3,55,56,56,12)

mergesort(TestArr2,0,3,8)
TestArr2
mergesort(TestArr,1,3,8)
TestArr



def mergeLTB(arr: Array[Int], von: Int, rRdlH: Int, bis: Int): Unit =
  val tmpArray = Array.ofDim[Int](bis - von + 1)
  var idxTmp = 0
  var idxLinks = von
  var idxRechts = rRdlH + 1
  // So lange beide Teilarrays noch Werte enthalten: 
  while (idxLinks <= rRdlH && idxRechts <= bis) do
    if arr(idxLinks) < arr(idxRechts) then
      tmpArray(idxTmp) = arr(idxLinks)
      idxLinks += 1
      idxTmp += 1
    else
      tmpArray(idxTmp) = arr(idxRechts)
      idxRechts += 1
      idxTmp += 1
  // Jetzt ist genau eine Hälfte des zu mergenden Bereichs leer. Die
  // andere Hälfte kann also ohne Vergleiche kopiert werden.
  // Wenn die linke Hälfte des Arrays nicht leer ist, dann kopiere sie
  // ohne Vergleiche:       
  while idxLinks <= rRdlH do
    tmpArray(idxTmp) = arr(idxLinks)
    idxLinks += 1
    idxTmp += 1
  while idxRechts <= bis do
    tmpArray(idxTmp) = arr(idxRechts)
    idxRechts += 1
    idxTmp += 1
  for idx <- tmpArray.indices do
    arr(von + idx) = tmpArray(idx)

val mta1 = Array( -2, 5, 7, 5, 8, 12, 13, 27 )
mergeLTB( mta1, 0, 2, 7 )
mta1

val mta2 = Array( 100, 5, 7, 99, 8, 12, 13, 27, -100 )
mergeLTB(mta2, 1, 3, 7)
mta2

val mta3 = Array( 100, 5, -100 )
mergeLTB(mta3, 1, 1, 1)
mta3

val mta4 = Array( 100, 5, 3, -100 )
mergeLTB(mta4, 1, 1, 2)
mta4

def mergesort(arr: Array[Int]) : Unit =
  def mergesortrek(von: Int, bis:Int): Unit =
    //Rekabbruch
    if von >= bis then
      return
    var rRdlH = (von+bis)/2
    mergesortrek(von,rRdlH)
    mergesortrek(rRdlH+1,bis)
    mergeLTB(arr,von,rRdlH,bis)
  mergesortrek(0,arr.length-1)  
