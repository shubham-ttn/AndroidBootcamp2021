package com.example.androidbootcamp2021

import android.app.job.JobInfo
import android.app.job.JobParameters
import android.app.job.JobScheduler
import android.content.ComponentName
import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    companion object{
        const val jobId = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startJobButton.setOnClickListener {
            startJob()
        }

        // You can cancel the job
        // If it's not started yet
        stopJobButton.setOnClickListener {
            stopJob()
        }
    }

    private fun stopJob() {
        val jobScheduler = getSystemService(Context.JOB_SCHEDULER_SERVICE) as JobScheduler
        jobScheduler.cancel(jobId)
    }

    private fun startJob() {
        Toast.makeText(this, "Job will start in 5 seconds...", Toast.LENGTH_SHORT).show()

        val jobService = ComponentName(this, MyJobScheduler::class.java)
        val jobInfo = JobInfo
            .Builder(jobId, jobService)
            .setMinimumLatency(5000)
            .build()

        val jobScheduler = getSystemService(Context.JOB_SCHEDULER_SERVICE) as JobScheduler
        if (jobScheduler.schedule(jobInfo) <= 0) {
            Toast.makeText(this, "There is problem while scheduling job", Toast.LENGTH_SHORT).show()
        }

    }


}