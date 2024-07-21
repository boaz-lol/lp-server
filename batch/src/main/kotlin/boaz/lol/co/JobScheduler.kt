package boaz.lol.co

import org.springframework.batch.core.JobParameter
import org.springframework.batch.core.JobParameters
import org.springframework.batch.core.JobParametersInvalidException
import org.springframework.batch.core.launch.JobLauncher
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException
import org.springframework.batch.core.repository.JobRestartException
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.Scheduled

@Configuration
class JobScheduler(
    private val jobLauncher: JobLauncher,
    private val jobConfiguration: JobConfiguration
) {

    @Scheduled(cron = "0 */1 * * * *")
    @Throws(JobInstanceAlreadyCompleteException::class, JobExecutionAlreadyRunningException::class, JobParametersInvalidException::class, JobRestartException::class)
    fun runJob() {
        val confMap: HashMap<String, JobParameter<Long>> = HashMap<String, JobParameter<Long>>()
        confMap["time"] = JobParameter(System.currentTimeMillis(), Long::class.java, true)

        val jobParameters = JobParameters(confMap as MutableMap<String, JobParameter<*>>)
        try {
            jobLauncher.run(jobConfiguration.job(), jobParameters)
        } catch (e: JobExecutionAlreadyRunningException) {
            throw e
        } catch (e: JobInstanceAlreadyCompleteException) {
            throw e
        } catch (e: JobParametersInvalidException) {
            throw e
        } catch (e: JobRestartException) {
            throw e
        }
    }

}