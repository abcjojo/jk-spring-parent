/*
 * Copyright (c) 2020 pig4cloud Authors. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.liyijun.jk.constants;

/**
 * 公共常量
 */
public interface CommonConstants {

	/** 编码*/
	String UTF8 = "UTF-8";

	/** JSON 资源*/
	String CONTENT_TYPE = "application/json; charset=utf-8";

	/** 成功标记*/
	Integer SUCCESS = 0;

	/** 失败标记*/
	Integer FAIL = 1;

	/** 当前页*/
	String CURRENT = "current";

	/** size*/
	String SIZE = "size";


	/** admin用户*/
	Integer USER_ADMIN = 0;
	/** shop用户*/
	Integer USER_SHOP = 1;
	/** 员工用户*/
	Integer USER_STAFF = 2;
	/** 业主用户*/
	Integer USER_CUSTOMER = 3;

	/** admin角色*/
	Integer ROLE_ADMIN = 1;
	/** shop角色*/
	Integer ROLE_SHOP = 2;
	/** other角色*/
	Integer ROLE_OTHER = 3;



}
