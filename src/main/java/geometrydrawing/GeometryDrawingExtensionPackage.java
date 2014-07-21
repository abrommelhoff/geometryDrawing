package main.java.geometrydrawing;

import uk.ac.ed.ph.jqtiplus.ExtensionNamespaceInfo;
import uk.ac.ed.ph.jqtiplus.JqtiExtensionPackage;
import uk.ac.ed.ph.jqtiplus.JqtiLifecycleEventType;
import uk.ac.ed.ph.jqtiplus.internal.util.ObjectUtilities;
import uk.ac.ed.ph.jqtiplus.node.QtiNode;
import uk.ac.ed.ph.jqtiplus.node.expression.ExpressionParent;
import uk.ac.ed.ph.jqtiplus.node.expression.operator.CustomOperator;
import uk.ac.ed.ph.jqtiplus.node.item.interaction.CustomInteraction;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GeometryDrawingExtensionPackage implements JqtiExtensionPackage<GeometryDrawingExtensionPackage> {

    public static final String DISPLAY_NAME = "GeometryDrawing QTI Extension";
    private final Map<String, ExtensionNamespaceInfo> namespaceInfoMap;
    private final Set<String> customOperatorClasses;
	private final Set<String> customInteractionClasses;

    public GeometryDrawingExtensionPackage() {
        final ExtensionNamespaceInfo extensionNamespaceInfo = new ExtensionNamespaceInfo(
                GeometryDrawingConstants.GEOMETRYDRAWING_NAMESPACE_URI, GeometryDrawingConstants.GEOMETRYDRAWING_SCHEMA_LOCATION,
                GeometryDrawingConstants.GEOMETRYDRAWING_DEFAULT_NAMESPACE_PREFIX);
        final Map<String, ExtensionNamespaceInfo> namespaceInfoMapSource = new HashMap<String, ExtensionNamespaceInfo>();
        namespaceInfoMapSource.put(extensionNamespaceInfo.getNamespaceUri(), extensionNamespaceInfo);
        this.namespaceInfoMap = ObjectUtilities.unmodifiableMap(namespaceInfoMapSource);
        this.customOperatorClasses = Collections.unmodifiableSet(new HashSet<String>());
        this.customInteractionClasses = Collections.unmodifiableSet(new HashSet<String>(Arrays.asList(
                GeometryDrawingConstants.GEOMETRYDRAWING_INTERACTION_CLASS
        )));
    }

    @Override
    public void lifecycleEvent(final Object source, final JqtiLifecycleEventType eventType) {
        return;
    }

    @Override
    public String getDisplayName() {
        return DISPLAY_NAME;
    }

    @Override
    public Map<String, ExtensionNamespaceInfo> getNamespaceInfoMap() {
        return namespaceInfoMap;
    }

    @Override
    public boolean implementsCustomOperator(final String operatorClassName) {
        return customOperatorClasses.contains(operatorClassName);
    }

    @Override
    public boolean implementsCustomInteraction(final String interactionClassName) {
    	return customInteractionClasses.contains(interactionClassName);
    }

    @Override
    public CustomOperator<GeometryDrawingExtensionPackage> createCustomOperator(final ExpressionParent expressionParent, final String operatorClassName) {
        return null;
    }

    @Override
    public CustomInteraction<GeometryDrawingExtensionPackage> createCustomInteraction(final QtiNode parentObject, final String interactionClassName) {
    	if (GeometryDrawingConstants.GEOMETRYDRAWING_INTERACTION_CLASS.equals(interactionClassName)) {
            return new GeometryDrawingInteraction(parentObject);
        }
        return null;
    }
}

