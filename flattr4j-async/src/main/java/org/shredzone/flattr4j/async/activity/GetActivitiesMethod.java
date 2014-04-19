/*
 * flattr4j - A Java library for Flattr
 *
 * Copyright (C) 2014 Richard "Shred" Körber
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
package org.shredzone.flattr4j.async.activity;

import java.util.List;

import org.shredzone.flattr4j.FlattrService;
import org.shredzone.flattr4j.async.AbstractFlattrCallable;
import org.shredzone.flattr4j.async.FlattrCallable;
import org.shredzone.flattr4j.model.Activity;
import org.shredzone.flattr4j.model.UserId;

/**
 * {@link FlattrCallable} for invoking
 * {@link FlattrService#getActivities(UserId, org.shredzone.flattr4j.model.Activity.Type)}
 *
 * @author Iulius Gutberlet
 * @author Richard "Shred" Körber
 */
public class GetActivitiesMethod extends AbstractFlattrCallable<List<Activity>> {
    private static final long serialVersionUID = -7513017427659726009L;

    private UserId userId;
    private Activity.Type type;

    public GetActivitiesMethod() {
        // default constructor
    }

    public GetActivitiesMethod(UserId userId, Activity.Type type) {
        this.userId = userId;
        this.type = type;
    }

    public UserId getUserId()                   { return userId; }
    public void setUserId(UserId userId)        { this.userId = userId; }

    public Activity.Type getType()              { return type; }
    public void setType(Activity.Type type)     { this.type = type; }

    @Override
    public List<Activity> call(FlattrService service) throws Exception {
        return service.getActivities(userId, type);
    }

}
