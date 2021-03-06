package com.zee.zee5app.repository;

import com.zee.zee5app.dto.Subscription;

public class SubscriptionRepo {
	private Subscription[] subscriptions=new Subscription[100];
	private static int count=0;
	
	public Subscription[] getSubscriptions()
	{
		return subscriptions;
	}
	
	public String addSubcription(Subscription subscription)
	{
		if(count==subscriptions.length)
		{
			Subscription temp[]=new Subscription[subscriptions.length*2];
			System.arraycopy(subscriptions, 0, temp, 0, subscriptions.length);
			subscriptions=temp;
		}
		subscriptions[count++]=subscription;
		return "success";
	}
	
	public Subscription getUserById(String subId)
	{
		for (Subscription subscription : subscriptions) {
			if(subscription!=null && subscription.getSubID().equals(subId))
				return subscription;
		}
		return null;
	}
	
	public String modifySubscription(String subId,Subscription subscription)
	{
		for(Subscription subscription1:subscriptions)
		{
			if(subscription1!=null && subscription1.getSubID().equals(subId))
			{
				subscription1=subscription;
				return "success";
			}
		}
		return "id does not exist";
	}
	private static SubscriptionRepo repo;
	public static SubscriptionRepo getInstance()
	{
		if(repo==null)
			repo=new SubscriptionRepo();
		return repo;
	}
}
