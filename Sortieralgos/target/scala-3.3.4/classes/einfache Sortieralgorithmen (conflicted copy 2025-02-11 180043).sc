val testArrays = List[Array[Int]](
  Array(),
  Array(4),
  Array(4,5),
  Array(5,4),
  Array(7,6,5),
  Array(4,3,2,1),
  Array(4,4,4,4),
  Array(1,2,3,4,5,1),
  Array(8,1,2,3,4,5),
  Array(9,8,7,6,5,4)
)

def sortieralgoTesten(algorithmus: Array[Int] => Unit): Unit =
  var alleTestsOK = true
  for testArray <- testArrays do
    val kopie = testArray.clone
    algorithmus(kopie)
    if ! (kopie sameElements testArray.sorted) then
      alleTestsOK = false
      println("Fehler: Array " + testArray.mkString(","))
      println("sieht nach Sortierung so aus: " + kopie.mkString(","))
      println("müsste aber so aussehen: " + testArray.sorted.mkString(","))
  if alleTestsOK then
    println("Alle Tests OK!")



// sortiert das zu sortierende Array "zs" in-place (also ohne ein neues Array anzulegen)
def bubblesort( zs: Array[Int] ): Unit =
  if zs.length > 1 then
    for abHierFertig <- zs.length to 2 by -1 do
      for vglPartli <-0 to abHierFertig -2 do
        if zs(vglPartli) > zs(vglPartli+1) then
          val temp = zs(vglPartli)
          zs(vglPartli) = zs(vglPartli+1)
          zs(vglPartli+1) = temp


sortieralgoTesten(bubblesort)



// sortiert das zu sortierende Array "zs" in-place (also ohne ein neues Array anzulegen)
def selectionsort( zs: Array[Int] ): Unit =
  if zs.length > 1 then
    for Runden <- 1 to zs.length-1 do
      var tempmax = zs(0)
      var tempmaxidx = 0
      for idx <-1 to zs.length-Runden do
        if zs(idx) > tempmax then
          tempmax = zs(idx)
          tempmaxidx = idx
      zs(tempmaxidx) = zs(zs.length-Runden)
      zs(zs.length-Runden) = tempmax

sortieralgoTesten(selectionsort)


def insertionsort( zs: Array[Int] ): Unit =
  // Muss Array Sortiert werden
  if zs.length>1 then
    // Fertiger Bereich
    for schonSortiert <- 0 to zs.length-2 do
      //schauen ob einsortiert werden muss
      if zs(schonSortiert) > zs(schonSortiert+1) then
        // einzusortierender Partner zwischen Speichern
        val einzusortpart = zs(schonSortiert+1)
        // var für linken vergleichspartner von einzusortpart
        var linkervglpart = schonSortiert
          // solange einzusortpart kleiner vglpart switche beide
        //var loop = true
        //while einzusortpart<zs(linkervglpart) && einzusortpart!=zs(0) && loop==true do
        while linkervglpart >= 0 && einzusortpart<zs(linkervglpart) do
          zs(linkervglpart+1) = zs(linkervglpart)
          zs(linkervglpart) = einzusortpart
          //if linkervglpart > 0 then
          linkervglpart = linkervglpart - 1
          //else
          //  loop = false
          //if linkervglpart < 0 then
            
            

sortieralgoTesten(insertionsort)



def bubblesort2 ( zs: Array[Int] ): Unit=
  // jede Runde ein wert weniger vergleichen
  for abHierFertig <- zs.length-1 to 1 by -1 do
    for linkervglpart <-0 to zs.length-1 do
      var rechtervglpart = linkervglpart + 1
      // wenn wir noch zahlen vergleichen müssen,
      // die wir nicht schon letzte runde als max wert hatten:
      if abHierFertig>=rechtervglpart then
        // Wenn links größer rechts dann tausche
        if zs(linkervglpart) > zs(rechtervglpart) then
          var temp = zs(rechtervglpart)
          zs(rechtervglpart) = zs(linkervglpart)
          zs(linkervglpart)=temp


sortieralgoTesten(bubblesort2)

//def selectionsort2 (zs: Array[Int]): Unit=
  


// KA Üben:
def pyramide =
  for zeile<-1 to 5 do 
    print("."*(6-zeile))
    for wert<- 6-zeile to 4+zeile do 
      print(wert)
    println() 
    
    
print(pyramide)    

def pyZeile(startBei: Int)=
  print("."*(6-startBei))
  for wert<- 6-startBei to 4+startBei do 
    print(wert)
    
    print(pyZeile(2))
    
    
    
