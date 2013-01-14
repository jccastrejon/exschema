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
package fr.imag.exschema.exporter;

/**
 * To be implemented by classes that can generate Spring Roo commands.
 * 
 * @author jccastrejon
 * 
 */
public interface RooExporter {

    /**
     * Get the appropriate Spring Roo commands for this object, according to the
     * specified Roo model.
     * 
     * @param rooModel
     * @return
     */
    public String getRooCommands(final RooModel rooModel);
}