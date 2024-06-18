package boaz.lol.co.storage.redis.service

import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.core.ValueOperations
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer
import org.springframework.stereotype.Component
import java.util.concurrent.TimeUnit


@Component
class RedisUtil(private val redisTemplate: RedisTemplate<String, String>) {

    fun setValues(key: String, data: String) {
        val values: ValueOperations<String, String> = redisTemplate.opsForValue()
        values.set(key, data)
    }

    fun setValues(key: String, data: String, duration: Long) {
        val values: ValueOperations<String, String> = redisTemplate.opsForValue()
        values[key] = data
        redisTemplate.expire(key, duration, TimeUnit.MILLISECONDS)
    }

    fun getValues(key: String): String? {
        val values: ValueOperations<String, String> = redisTemplate.opsForValue()
        return values.get(key)
    }

    fun deleteValues(key: String) {
        redisTemplate.delete(key)
    }
}