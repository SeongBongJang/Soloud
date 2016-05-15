package com.soloud.util;

import net.sf.json.*;

public class MakeTree 
{
	private JSONArray jsonArray;
	private JSONArray _treeModel;
	//전체 데이터 길이
	private int _listLength;
	//트리 크기
	private int _treeLength=0;
	//반복횟수
	private int _loopLength=0;
	
	public MakeTree()
	{
		this.jsonArray=new JSONArray();
		this._treeModel=new JSONArray();
		//this._listLength=
	}
	public MakeTree(JSONArray arr)
	{
		this.jsonArray=arr;
		this._treeModel=new JSONArray();
		//this._listLength=
		//System.out.println(arr.toString());
		this._listLength=arr.size();
	}
	public JSONArray createTreeGo()
	{
		JSONObject a =  new JSONObject();
		a.put("_rootId", "{'id':'root'}");
		return getTreeModel(this.jsonArray, a);
	}
	public JSONArray createTreeGo(String root)
	{
		JSONObject a =  new JSONObject();
		a.put("_rootId", "{'id':'"+ root +"'}");
		return getTreeModel(this.jsonArray, a);
	}
	
	public JSONArray getTreeModel(JSONArray _list, JSONObject _rootId)
	{
		//System.out.println("asd");
		while(this._treeLength != this._listLength && this._listLength != this._loopLength++)
		{
			//System.out.println(this.jsonArray.toString());
			for(int i=0; i<_list.size(); i++)
			{
				
				JSONObject item = (JSONObject) _list.get(i);
				
			//	System.out.println(item.get("parentId"));
			//	System.out.println(_rootId.get("_rootId"));
				if(item.get("parentId").equals(_rootId.get("_rootId")))
				{
					JSONObject view = new JSONObject();
					view.put("data", item.get("data"));
					view.put("attr", item.get("attr"));
					view.put("children", new JSONArray());
				
					this._treeModel.add(view);
					this._treeLength++;
					_list.remove(i);
					break;
				}
				else
				{
					getParentNode(_treeModel, item);
				}
			}
		}
		return this._treeModel;
	}
	public void getParentNode(JSONArray _children, JSONObject item)
	{
		for(int i=0; i<_children.size(); i++)
		{
			JSONObject child = (JSONObject) _children.get(i);
	
			if(child.get("attr").equals(item.get("parentId")))
			{
				JSONObject view = new JSONObject();
				view.put("data", item.get("data"));
				view.put("attr", item.get("attr"));
				view.put("children", new JSONArray());
				((JSONArray)child.get("children")).add(view);
				_treeLength++;
				this.jsonArray.remove(this.jsonArray.indexOf(item));
				break;
			}
			else
			{
				if(((JSONArray)child.get("children")).size() != 0)
				{
					getParentNode((JSONArray)child.get("children"), item);
				}
			}
		}
	}
	
	
	public JSONArray getJsonArray() {
		return jsonArray;
	}

	public void setJsonArray(JSONArray jsonArray) {
		this.jsonArray = jsonArray;
	}

	public JSONArray get_treeModel() {
		return _treeModel;
	}

	public void set_treeModel(JSONArray _treeModel) {
		this._treeModel = _treeModel;
	}

	public int get_listLength() {
		return _listLength;
	}

	public void set_listLength(int _listLength) {
		this._listLength = _listLength;
	}

	public int get_treeLength() {
		return _treeLength;
	}

	public void set_treeLength(int _treeLength) {
		this._treeLength = _treeLength;
	}

	public int get_loopLength() {
		return _loopLength;
	}

	public void set_loopLength(int _loopLength) {
		this._loopLength = _loopLength;
	}
	
	
	
}
