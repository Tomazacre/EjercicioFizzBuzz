import java.math.BigDecimal

fun main() {
    val ingr = readLine().toString()
    println(calMulti(ingr.toInt()))
}

fun calMulti(numIng: Int): String {
    if ((numIng % 5) == 0){
        return "Fizz!"
    }
    if ((numIng % 3) == 0){
        return "Buzz!"
    }
    if ((numIng % 3) == 0 && (numIng % 5) == 0){
        return "FizzBuzz!"
    }else {
        var cantLet = "".toString()
        val bdTot = BigDecimal(numIng).setScale(2, BigDecimal.ROUND_DOWN)
        val inte = bdTot.toBigInteger().toLong()
        val auxMill = (inte.toInt() / 1000000) % 1000

        if (inte == 0L) {
            cantLet += "Cero "
        }
        if (auxMill > 0){
            cantLet += strGen(auxMill)
        }
        if (auxMill == 1){
            cantLet += "Millón "
        } else if (auxMill > 1){
            cantLet += "Millones "
        }

        val aux = numIng % 1000
        val auxMil = (numIng / 1000) % 1000

        if (auxMil > 0){
            cantLet += strGen(auxMil) + "Mil "
        }
        if (aux > 0) {
            cantLet += strGen(aux)
        }

        return cantLet
    }
}


private fun strGen(n: Int): String {
    var result = "".toString()
    val auxUn = n / 100
    val auxDs = (n % 100) / 10
    val auxTs = n % 10


    when (auxUn) {
        1 -> if (auxDs == 0 && auxTs == 0) {
            result += "Cien "
            return result
        } else {
            result += "Ciento "
        }
        2 -> result += "Doscientos "
        3 -> result += "Trescientos "
        4 -> result += "Cuatrocientos "
        5 -> result += "Quinientos "
        6 -> result += "Seiscientos "
        7 -> result += "Setecientos "
        8 -> result += "Ochocientos "
        9 -> result +="Novecientos "
    }


    when (auxDs) {
        1 -> if (auxTs == 0) {
            result += "Diez "
            return result
        } else if (auxTs == 1) {
            result += "Once "
            return result
        } else if (auxTs == 2) {
            result += "Doce "
            return result
        } else if (auxTs == 3) {
            result += "Trece "
            return result
        } else if (auxTs == 4) {
            result += "Catorce "
            return result
        } else if (auxTs == 5) {
            result += "Quince "
            return result
        } else {
            result += "Dieci"
        }

        2 -> if (auxTs == 0) {
            result += "Veinte "
            return result
        } else {
            result += "Veinti"
        }

        3 -> result += "Treinta "
        4 -> result += "Cuarenta "
        5 -> result += "Cincuenta "
        6 -> result += "Sesenta "
        7 -> result += "Setenta "
        8 -> result += "Ochenta "
        9 -> result += "Noventa "
    }


    if (auxDs > 2 && auxTs > 0) {
        result += "y "
    }


    when (auxTs) {
        1 -> result += "Un "
        2 -> result += "Dos "
        3 -> result += "Tres "
        4 -> result += "Cuatro "
        5 -> result += "Cinco "
        6 -> result += "Seis "
        7 -> result += "Siete "
        8 -> result += "Ocho "
        9 -> result += "Nueve "
    }
    return result
}