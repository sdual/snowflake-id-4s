package com.github.sdual.snowflakeid

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class SnowflakeIdConfigSpec extends AnyWordSpec with Matchers {

  "ConfigParam" should {
    "create node id from mac address" in {
      val actual = ConfigParam.createNodeIdFromMacAddress()
      actual should not equal null
    }
  }

}
