/*******************************************************************************
 * Copyright (c) 2011 Red Hat, Inc.
 *  All rights reserved.
 * This program is made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Red Hat, Inc. - initial API and implementation
 *
 * @author Bob Brodt
 ******************************************************************************/


package org.eclipse.bpmn2.modeler.ui.property.gateways;

import org.eclipse.bpmn2.modeler.core.merrimac.clad.AbstractBpmn2PropertySection;
import org.eclipse.bpmn2.modeler.core.merrimac.clad.DefaultDetailComposite;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.widgets.Composite;

public class GatewayDetailComposite extends DefaultDetailComposite {

	private AbstractPropertiesProvider itemProvider;

	/**
	 * @param section
	 */
	public GatewayDetailComposite(AbstractBpmn2PropertySection section) {
		super(section);
	}
	
	public GatewayDetailComposite(Composite parent, int style) {
		super(parent, style);
	}

	@Override
	public AbstractPropertiesProvider getPropertiesProvider(EObject object) {
		if (itemProvider == null) {
			itemProvider = new AbstractPropertiesProvider(object) {
				// lump all the gateway properties into one composite
				// if a gateway doesn't have one of the attributes listed here,
				// it simply won't be displayed.
				String[] properties = new String[] {
						"gatewayDirection",
						"instantiate",
						"activationCondition",
						"eventGatewayType"
						// note: "default" sequence flow is already being displayed in the SequenceFlow tab
						// so, no need to show it here
				};
				
				@Override
				public String[] getProperties() {
					return properties; 
				}
			};
		}
		return itemProvider;
	}
}