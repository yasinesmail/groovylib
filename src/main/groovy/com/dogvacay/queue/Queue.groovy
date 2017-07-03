package com.dogvacay.queue

import com.surftools.BeanstalkClientImpl.ClientImpl
import com.surftools.BeanstalkClient.Client
//import com.surftools.BeanstalkClient.while (condition) {

class Queue {
	
	private static def local = [name:"local", url:'events-queue.dogvacay.com', port:8081]
	private static def sandbox = [name:"sandbox", url:'events-queue.dogvacay.com', port:8081]
	
	public static connect(qConfig) {
		Client queue = new ClientImpl(qConfig.url, qConfig.port)	
		return queue
	}
	
	def listAllQueues(queues) {
		return queues.listTubeUsed();
	}

}
