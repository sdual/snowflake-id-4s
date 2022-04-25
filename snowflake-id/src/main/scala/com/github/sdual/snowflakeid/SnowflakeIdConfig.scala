package com.github.sdual.snowflakeid

import java.net.NetworkInterface

case class SnowflakeIdConfig(customEpoch: Long = ConfigParam.DEFAULT_EPOCH,
                             nodeId: Long = ConfigParam.NODE_ID)

object ConfigParam {
  val DEFAULT_EPOCH: Long = 1420070400000L // 2015-01-01T00:00:00Z
  lazy val NODE_ID: Long = createNodeIdFromMacAddress()

  def createNodeIdFromMacAddress(): Long = {
    val networkInterfaces: java.util.Enumeration[NetworkInterface] = NetworkInterface.getNetworkInterfaces
    val sb: StringBuilder = new StringBuilder()

    while (networkInterfaces.hasMoreElements) {
      val networkInterface = networkInterfaces.nextElement()

      Option(networkInterface.getHardwareAddress).toList.map(macAddress =>
        macAddress.toList
          .foldLeft(sb)((byteStrBuilder, byte) =>
            byteStrBuilder.append(String.format("%02X", byte))
          )
      )
    }

    sb.toString().hashCode.toLong
  }

}
