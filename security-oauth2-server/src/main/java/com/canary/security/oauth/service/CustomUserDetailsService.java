/*
 * Copyright 2014-2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.canary.security.oauth.service;


import com.canary.biz.acl.intf.AclAccountFacade;
import com.canary.core.acl.AclAccountDTO;
import com.canary.m.common.client.AccountUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author jiahao
 * @Package com.canary.security.oauth.oauth
 * @Description: 实现spring security 的UserDetailsService， security自动会自动调用其属性进行相应校验
 * @date 2017/11/7 16:40
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private AclAccountFacade aclAccountFacade;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AclAccountDTO account = aclAccountFacade.getAccountInfoByAccount(username);
        if (account == null) {
            throw new UsernameNotFoundException(String.format("User %s does not exist!", username));
        }
        int shopId = 0;
        boolean userCredentials = false;
        boolean shopCredentials = false;
        return new AccountUserDetails(account, shopId, userCredentials, shopCredentials);
    }

}
