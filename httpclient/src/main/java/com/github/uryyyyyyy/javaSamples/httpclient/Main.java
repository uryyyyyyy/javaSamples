package com.github.uryyyyyyy.javaSamples.httpclient;

import javax.naming.AuthenticationException;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.*;
import java.util.Enumeration;
import java.util.Hashtable;

public class Main {

    public static void main(String[] args) {

        Hashtable env = new Hashtable();

        env.put(Context.INITIAL_CONTEXT_FACTORY,
                "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, "ldap://localhost:9999");
        env.put("java.naming.ldap.version" , "3" );
        env.put(Context.SECURITY_PRINCIPAL , "cn=shiba@gmail.com,ou=people,dc=nodomain" );
        env.put(Context.SECURITY_CREDENTIALS, "test");

        try {
            // bind認証する
            DirContext dirContext = new InitialDirContext(env);
            search(dirContext);
            //modify(dirContext);
            create(dirContext);
            //delete(dirContext);
            System.out.println("認証OK");
        } catch (AuthenticationException ae) {
            System.out.println("認証NG");
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public static void delete(DirContext dirContext) throws NamingException{
        System.out.println("delete start");
        dirContext.destroySubcontext("uid=shiba@gmail.com,ou=people,dc=nodomain");
        System.out.println("delete done");
    }

    private static void create(DirContext dirContext) throws NamingException {
        System.out.println("crate start");
        Attributes attrs = new BasicAttributes();

        Attribute attrEmpId = new BasicAttribute( "cn" );
        attrEmpId.add( 0 , "shiba@gmail.com" );
        attrs.put( attrEmpId );

        Attribute attrPassId = new BasicAttribute( "userPassword" );
        attrPassId.add( 0 , "test" );
        attrs.put( attrPassId );

        Attribute attrEmail = new BasicAttribute( "mail" );
        attrEmail.add(0 , "shiba@gmail.com" );
        attrs.put( attrEmail );

        Attribute attrSn = new BasicAttribute( "sn" );
        attrSn.add( 0 , "shiba" );
        attrs.put( attrSn );

        Attribute attrObjClass = new BasicAttribute( "objectClass" );
        attrObjClass.add( 0 , "inetOrgPerson");
        attrs.put( attrObjClass );

        dirContext.createSubcontext("uid=shiba@gmail.com,ou=people,dc=nodomain" , attrs );
        System.out.println("create done");
    }

    private static void modify(DirContext dirContext) throws NamingException {
        System.out.println("modify start");
        ModificationItem[] mods = new ModificationItem[2];
        Attribute attrSn = new BasicAttribute( "sn" , "Doe2" );
        mods[0] = new ModificationItem( DirContext.REPLACE_ATTRIBUTE , attrSn );
        Attribute attrMail = new BasicAttribute( "mail" , "sample@gmail.com" );
        mods[1] = new ModificationItem( DirContext.REPLACE_ATTRIBUTE , attrMail );
        dirContext.modifyAttributes("uid=john,ou=people,dc=nodomain", mods);
        System.out.println("modify done");
    }


    private static void search(DirContext dirContext) throws NamingException {
        SearchControls searchControls = new SearchControls();
        searchControls.setSearchScope( SearchControls.SUBTREE_SCOPE );
        NamingEnumeration searchResultEnum = dirContext.search("ou=people,dc=nodomain", "givenName=john", searchControls);
        while ( searchResultEnum.hasMore() ){
            SearchResult searchResult =
                    (SearchResult)searchResultEnum.next();
            // 属性の集合を取得
            NamingEnumeration attrs = searchResult.getAttributes().getAll();

            while ( attrs.hasMore() ) {
                Attribute attr = (Attribute) attrs.nextElement();
                System.out.println(attr.getID());
                Enumeration attrValEnum = attr.getAll(); // 属性値の集合
                while (attrValEnum.hasMoreElements()) {
                    try{
                        String elem = (String)attrValEnum.nextElement();
                        System.out.println(elem);
                    }catch(ClassCastException e){
                        System.out.println("cannot convert to string");
                    }
                }
            }
        }
    }

}