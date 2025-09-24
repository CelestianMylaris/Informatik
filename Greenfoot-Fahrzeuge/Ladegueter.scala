// Filtered on Montag 2025-Februar-24 at 11:23:33 by Tippfilter 0.5-rc4-3-g3f1bba0 (development or dirty build)
import greenfoot.Actor;

/** Die Klasse ILadegut beschreibt Eigenschaften von Objekten, die anderswo 
 * (insbesondere in LKWs) eingeladen werden können.
 * 
 * Diese Eigenschaften sind konkret ihre Masse in kg (vom Typ int) und die
 * Information, ob sie gefährlich sind (vom Typ boolean), sowie get-Methoden
 * dafür.
 * 
 * @author Urs Lautebach
 * @version 2020-Oktober
 */
abstract class Ladegut_S(val masse: Int, val istGefaehrlich: Boolean) extends Actor: 
    /** get-ter für das Attribut Masse
     * @return wie schwer dieses Ladegut ist (in kg).     */
    def getMasse: Int =
       ???

    /** get-ter für das Attribut istGefahrgut
     *  @return ob Ladegut als gefährlich gilt. */
    def istGefahrgut: Boolean =
       ???


/**
 * Bombe dient als Beispiel für ein Ladegut, das als Gefahrgut gelten muss.
 * Alle Bomben wiegen 50 kg.
 * 
 * @author Urs Lautebach
 * @version 2020-Oktober
 */
class Bombe_S extends Ladegut_S(50, true)


/** Fass dient als Beispiel für ein Ladegut, das manchmal  gefährlich ist und
 * manchmal nicht. Auch das Gewicht kann verschieden sein. 
 * 
 * @author Urs Lautebach
 * @version 2020-Oktober
 */
class Fass_S(masse: Int, istGefaehrlich: Boolean) extends Ladegut_S(masse, istGefaehrlich)


/**
 * Teddy dient als Beispiel für ein Ladegut, das kein Gefahrgut ist.
 * Alle Teddys wiegen 1 kg.
 * 
 * @author Urs Lautebach
 * @version 2020-Oktober
 */
class Teddy_S extends Ladegut_S(1, false)

