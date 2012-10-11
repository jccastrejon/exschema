/*
 * Copyright 2012 jccastrejon
 *  
 * This file is part of ExSchema.
 *
 * ExSchema is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * any later version.
 *
 * ExSchema is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.

 * You should have received a copy of the GNU General Public License
 * along with ExSchema. If not, see <http://www.gnu.org/licenses/>.
 */
package fr.imag.exschema.hbase;

import fr.imag.exschema.UpdateVisitor;

/**
 * Identifies when data is added to HBase columns.
 * 
 * @author jccastrejon
 * 
 */
public class PutAddVisitor extends UpdateVisitor {
    @Override
    protected String getMethodBinding() {
        return "org.apache.hadoop.hbase.client.Put";
    }

    @Override
    protected String getMethodName() {
        return "add";
    }
}
