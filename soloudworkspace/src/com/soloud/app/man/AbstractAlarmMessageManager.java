package com.soloud.app.man;

import com.soloud.app.manInt.AlarmMessageAlarmable;
import com.soloud.app.manInt.AlarmMessageModifiable;
import com.soloud.app.manInt.AlarmMessageSearchable;
import com.soloud.app.model.AlarmMessageList;

public abstract class AbstractAlarmMessageManager implements AlarmMessageSearchable,AlarmMessageAlarmable, AlarmMessageModifiable{
	private static AlarmMessageList alarmMessageList;
	static
	{
		AbstractAlarmMessageManager.alarmMessageList = new AlarmMessageList();
	}
	public static synchronized AlarmMessageList getAlarmMessageList() {
		return alarmMessageList;
	}
	public static synchronized void setAlarmMessageList(AlarmMessageList alarmMessageList) {
		AbstractAlarmMessageManager.alarmMessageList = alarmMessageList;
	}
	
}
