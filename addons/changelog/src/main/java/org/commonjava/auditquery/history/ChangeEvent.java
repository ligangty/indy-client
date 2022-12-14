/**
 * Copyright (C) 2011-2020 Red Hat, Inc. (https://github.com/Commonjava/indy)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.commonjava.auditquery.history;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class ChangeEvent
        implements Serializable, Externalizable
{
    @JsonProperty
    private String eventId;

    @JsonProperty
    private String storeKey;

    @JsonProperty
    private Date changeTime;

    @JsonProperty
    private String version;

    @JsonProperty
    private String summary;

    @JsonProperty
    private ChangeType changeType;

    @JsonProperty
    private String user;

    @JsonProperty
    private String diffContent;

    public String getEventId()
    {
        return eventId;
    }

    public void setEventId( String eventId )
    {
        this.eventId = eventId;
    }

    public String getStoreKey()
    {
        return storeKey;
    }

    public void setStoreKey( String storeKey )
    {
        this.storeKey = storeKey;
    }

    public Date getChangeTime()
    {
        return changeTime;
    }

    public void setChangeTime( Date changeTime )
    {
        this.changeTime = changeTime;
    }

    public String getVersion()
    {
        return version;
    }

    public void setVersion( String version )
    {
        this.version = version;
    }

    public String getSummary()
    {
        return summary;
    }

    public void setSummary( String summary )
    {
        this.summary = summary;
    }

    public ChangeType getChangeType()
    {
        return changeType;
    }

    public void setChangeType( ChangeType changeType )
    {
        this.changeType = changeType;
    }

    public String getUser()
    {
        return user;
    }

    public void setUser( String user )
    {
        this.user = user;
    }

    public String getDiffContent()
    {
        return diffContent;
    }

    public void setDiffContent( String diffContent )
    {
        this.diffContent = diffContent;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash( storeKey, changeTime, version, summary, changeType, user, diffContent );
    }

    @Override
    public boolean equals( Object obj )
    {
        if ( this == obj )
        {
            return true;
        }
        if ( obj == null )
        {
            return false;
        }
        if ( getClass() != obj.getClass() )
        {
            return false;
        }
        final ChangeEvent other = (ChangeEvent) obj;

        return Objects.equals( storeKey, other.storeKey ) && Objects.equals( changeTime, other.changeTime )
                && Objects.equals( version, other.version ) && Objects.equals( summary, other.summary )
                && Objects.equals( changeType, other.changeType ) && Objects.equals( user, other.user )
                && Objects.equals( diffContent, other.diffContent );

    }

    @Override
    public void readExternal( ObjectInput in )
            throws IOException, ClassNotFoundException
    {
        this.eventId = (String) in.readObject();
        this.storeKey = (String) in.readObject();
        this.changeTime = (Date) in.readObject();
        this.version = (String) in.readObject();
        this.summary = (String) in.readObject();
        this.changeType = (ChangeType) in.readObject();
        this.user = (String) in.readObject();
        this.diffContent = (String) in.readObject();
    }

    @Override
    public void writeExternal( ObjectOutput out )
            throws IOException
    {
        out.writeObject( this.eventId );
        out.writeObject( this.storeKey );
        out.writeObject( this.changeTime );
        out.writeObject( this.version );
        out.writeObject( this.summary );
        out.writeObject( this.changeType );
        out.writeObject( this.user );
        out.writeObject( this.diffContent );
    }

}
