package boaz.lol.co.storage.redis.service

import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.core.ValueOperations
import org.springframework.stereotype.Service
import java.time.Duration


@Service
class RedisService(private val redisTemplate: RedisTemplate<String, String>) {

    fun setValues(key: String, data: String) {
        val values: ValueOperations<String, String> = redisTemplate.opsForValue()
        values.set(key, data)
    }

    fun setValues(key: String, data: String, duration: Duration) {
        val values: ValueOperations<String, String> = redisTemplate.opsForValue()
        values.set(key, data, duration)
    }

    fun getValues(key: String): String? {
        val values: ValueOperations<String, String> = redisTemplate.opsForValue()
        return values.get(key)
    }

    fun deleteValues(key: String) {
        redisTemplate.delete(key)
    }
}