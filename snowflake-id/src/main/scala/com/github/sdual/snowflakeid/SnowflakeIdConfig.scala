package com.github.sdual.snowflakeid

import java.net.NetworkInterface
import scala.annotation.tailrec

case class SnowflakeIdConfig(customEpoch: Long = ConfigParam.DEFAULT_EPOCH,
                             nodeId: Long = ConfigParam.MAC_ADDRESS_NODE_ID)

object ConfigParam {
  val DEFAULT_EPOCH: Long = 1420070400000L // 2015-01-01T00:00:00Z
  lazy val MAC_ADDRESS_NODE_ID: Long = createNodeIdFromMacAddress()

  def createNodeIdFromMacAddress(): Long = {
    val networkInterfaces: java.util.Enumeration[NetworkInterface] = NetworkInterface.getNetworkInterfaces

    @tailrec
    def loop(nis: java.util.Enumeration[NetworkInterface], octalString: String): Long = {

      if (networkInterfaces.hasMoreElements) {
        Option(nis.nextElement().getHardwareAddress) match {
          case Some(macAddress) =>
            loop(nis, macAddress.toList.foldLeft("")((octStr, byte) => octStr + String.format("%02X", byte)))
          case _ => loop(nis, octalString)
        }
      } else {
        octalString.hashCode
      }


    }

    loop(networkInterfaces, "")
  }
}
