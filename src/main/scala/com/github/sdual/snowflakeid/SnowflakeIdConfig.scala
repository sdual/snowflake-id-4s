package com.github.sdual.snowflakeid

import java.net.NetworkInterface

class SnowflakeIdConfig(customEpoch: Long = ConfigParam.DEFAULT_EPOCH, nodeId: Long) {

  def this(customEpoch: Long) {
    this(customEpoch, ConfigParam.createNodeIdFromMacAddress())
  }

}

object ConfigParam {
  val DEFAULT_EPOCH = 1420070400000L // 2015-01-01T00:00:00Z

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
