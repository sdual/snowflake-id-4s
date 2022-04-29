package com.github.sdual.snowflakeid

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

import java.net.NetworkInterface

class SnowflakeIdConfigSpec extends AnyWordSpec with Matchers {

  "ConfigParam" should {
    "create node id from mac address" in {
      val actual = ConfigParam.createNodeIdFromMacAddress()
      actual should not equal null
    }

//    "" in {
//      val networkInterfaces: java.util.Enumeration[NetworkInterface] = NetworkInterface.getNetworkInterfaces
//      while (networkInterfaces.hasMoreElements) {
//        val ni = networkInterfaces.nextElement()
//        println(ni.getName)
//      }
//    }
  }

  "SnowflakeIdConfig" should {
    "have default values" in {
      val actual = SnowflakeIdConfig()
      actual.nodeId should not equal null
      actual.customEpoch should equal (1420070400000L)
    }
  }

}
