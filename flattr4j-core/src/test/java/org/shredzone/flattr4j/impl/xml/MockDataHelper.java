/**
 * flattr4j - A Java library for Flattr
 *
 * Copyright (C) 2010 Richard "Shred" Körber
 *   http://flattr4j.shredzone.org
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License / GNU Lesser
 * General Public License as published by the Free Software Foundation,
 * either version 3 of the License, or (at your option) any later version.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 */
package org.shredzone.flattr4j.impl.xml;

import java.util.Date;
import org.junit.Assert;
import org.shredzone.flattr4j.model.Category;
import org.shredzone.flattr4j.model.Language;
import org.shredzone.flattr4j.model.RegisteredThing;
import org.shredzone.flattr4j.model.Thing;
import org.shredzone.flattr4j.model.ThingStatus;
import org.shredzone.flattr4j.model.User;

/**
 * A helper class providing and asserting mock data.
 * 
 * @author Richard "Shred" Körber
 * @version $Revision$
 */
public final class MockDataHelper {

    private MockDataHelper() {
        // Private constructor
    }

    /**
     * Creates a filled {@link Thing}.
     * 
     * @return {@link Thing}
     */
    public static Thing createThing() {
        Thing thing = new Thing();
        thing.setCategory("text");
        thing.setDescription("This is <em>a new Thing</em>");
        thing.setHidden(false);
        thing.setLanguage("en_UK");
        thing.setTitle("A thingy title");
        thing.setUrl("http://flattr4j.shredzone.org/thingy.html");
        thing.addTag("foo");
        thing.addTag("bar");
        thing.addTag("bla");
        return thing;
    }

    /**
     * Creates an XML structure that corresponds to the created {@link Thing}.
     * 
     * @return XML structure, as String
     */
    public static String createThingXml() {
        StringBuilder sb = new StringBuilder();
        sb.append("<thing>");
        sb.append("<url>http://flattr4j.shredzone.org/thingy.html</url>");
        sb.append("<title><![CDATA[A thingy title]]></title>");
        sb.append("<category>text</category>");
        sb.append("<description><![CDATA[This is <em>a new Thing</em>]]></description>");
        sb.append("<language>en_UK</language>");
        sb.append("<hidden>0</hidden>");
        sb.append("<tags>");
        sb.append("<tag>foo</tag>");
        sb.append("<tag>bar</tag>");
        sb.append("<tag>bla</tag>");
        sb.append("</tags>");
        sb.append("</thing>");
        return sb.toString();
    }

    /**
     * Asserts the result of the Category.xml resource.
     * 
     * @param cat1
     *            First {@link Category} object
     * @param cat2
     *            Second {@link Category} object
     */
    public static void assertCategoryResource(Category cat1, Category cat2) {
        Assert.assertEquals("text", cat1.getId());
        Assert.assertEquals("Written text", cat1.getName());

        Assert.assertEquals("images", cat2.getId());
        Assert.assertEquals("Images", cat2.getName());
    }

    /**
     * Asserts the result of the Language.xml resource.
     * 
     * @param lang1
     *            First {@link Language} object
     * @param lang2
     *            Second {@link Language} object
     */
    public static void assertLanguageResource(Language lang1, Language lang2) {
        Assert.assertEquals("sq_AL", lang1.getId());
        Assert.assertEquals("Albanian", lang1.getName());

        Assert.assertEquals("ar_DZ", lang2.getId());
        Assert.assertEquals("Arabic", lang2.getName());
    }

    /**
     * Asserts the result of the Thing.xml resource.
     * 
     * @param thing
     *            {@link RegisteredThing} object
     */
    public static void assertThingResource(RegisteredThing thing) {
        Assert.assertEquals("bf12b55dc73d89835fff9696b6cc3883", thing.getId());
        Assert.assertEquals("42343", thing.getIntId());
        Assert.assertEquals(new Date(1276784931L * 1000L), thing.getCreated());
        Assert.assertEquals("sv_SE", thing.getLanguage());
        Assert.assertEquals("http://www.kontilint.se/kontakt", thing.getUrl());
        Assert.assertEquals("Kontakta Kontilint", thing.getTitle());
        Assert.assertEquals("Kontakta Kontilint", thing.getDescription());
        Assert.assertEquals(0, thing.getClicks());
        Assert.assertEquals("244", thing.getUserId());
        Assert.assertEquals("Bomelin", thing.getUserName());
        Assert.assertEquals(3, thing.getTags().size());
        Assert.assertEquals("asd", thing.getTags().get(0));
        Assert.assertEquals("fgh", thing.getTags().get(1));
        Assert.assertEquals("ert", thing.getTags().get(2));
        Assert.assertEquals("text", thing.getCategory());
        Assert.assertEquals("Written text", thing.getCategoryName());
        Assert.assertEquals(ThingStatus.OWNER, thing.getStatus());
    }

    /**
     * Asserts the result of the User.xml resource.
     * 
     * @param thing
     *            {@link User} to assert
     */
    public static void assertUserResource(User user) {
        Assert.assertEquals("244", user.getId());
        Assert.assertEquals("Bomelin", user.getUsername());
        Assert.assertEquals("Mattias", user.getFirstname());
        Assert.assertEquals("Bomelin", user.getLastname());
        Assert.assertEquals("Skurup", user.getCity());
        Assert.assertEquals("Sweden", user.getCountry());
        Assert.assertEquals("https://secure.gravatar.com/avatar/59bc275a1d17a4f2ec448538426803bf?s=120&r=pg", user.getGravatar());
        Assert.assertEquals("mattias@flattr.com.invalid", user.getEmail());
        Assert.assertEquals("Flattr meee", user.getDescription());
        Assert.assertEquals(10, user.getThingcount());
    }

}