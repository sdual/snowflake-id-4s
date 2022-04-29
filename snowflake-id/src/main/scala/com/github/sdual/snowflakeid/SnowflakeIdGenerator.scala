package com.github.sdual.snowflakeid

class SnowflakeIdGenerator(config: SnowflakeIdConfig) {

  def generate(): Long = {
    ???
  }

}

object SnowflakeIdGenerator {

  def apply(): SnowflakeIdGenerator = new SnowflakeIdGenerator(SnowflakeIdConfig())

  def apply(nodeId: Long): SnowflakeIdGenerator =
    new SnowflakeIdGenerator(SnowflakeIdConfig(nodeId = nodeId))

  def apply(config: SnowflakeIdConfig): SnowflakeIdGenerator = new SnowflakeIdGenerator(config)

}
