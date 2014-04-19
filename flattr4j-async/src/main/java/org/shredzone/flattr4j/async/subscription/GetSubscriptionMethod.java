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
package org.shredzone.flattr4j.async.subscription;

import org.shredzone.flattr4j.FlattrService;
import org.shredzone.flattr4j.async.AbstractFlattrCallable;
import org.shredzone.flattr4j.async.FlattrCallable;
import org.shredzone.flattr4j.model.Subscription;
import org.shredzone.flattr4j.model.ThingId;

/**
 * {@link FlattrCallable} for invoking {@link FlattrService#getSubscription(ThingId)}
 *
 * @author Iulius Gutberlet
 * @author Richard "Shred" Körber
 */
public class GetSubscriptionMethod extends AbstractFlattrCallable<Subscription> {
    private static final long serialVersionUID = 5818269567756230088L;

    private ThingId thingId;

    public GetSubscriptionMethod() {
        // default constructor
    }

    public GetSubscriptionMethod(ThingId thingId) {
        this.thingId = thingId;
    }

    public ThingId getThingId()                 { return thingId; }
    public void setThingId(ThingId thingId)     { this.thingId = thingId; }

    @Override
    public Subscription call(FlattrService service) throws Exception {
        return service.getSubscription(thingId);
    }

}
