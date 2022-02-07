package com.example.apppeliculas.Core

import kotlinx.coroutines.coroutineScope
import java.net.InetSocketAddress
import java.net.Socket
//Check the conection
object internetCheck {
    suspend fun networkConectionOn() = coroutineScope {
        return@coroutineScope try {
            val sock = Socket()
            val socketAddress = InetSocketAddress("8.8.8.8",53)
            sock.connect(socketAddress, 1500)
            sock.close()
            true
        }catch (e: Exception){
            false
        }
    }

}