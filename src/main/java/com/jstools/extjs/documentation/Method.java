package com.jstools.extjs.documentation;

import com.jstools.extjs.common.AccessSpecifiers;

import java.util.List;

/**
 * Checks if the icon/iconCls changed from being empty to having a value, or having a value to being empty.
 * @private
 * @param {String} old The old icon/iconCls
 * @param {String} current The current icon/iconCls
 * @return {Boolean} True if the icon state changed
 */

public class Method extends DocumentElement {

    private AccessSpecifiers methodAccessLevel;
    private List<DocumentElementProperty> methodParameters;
    private DocumentElementProperty returnType;

    public AccessSpecifiers getMethodAccessLevel() {
        return methodAccessLevel;
    }

    public void setMethodAccessLevel(AccessSpecifiers methodAccessLevel) {
        this.methodAccessLevel = methodAccessLevel;
    }

    public List<DocumentElementProperty> getMethodParameters() {
        return methodParameters;
    }

    public void setMethodParameters(List<DocumentElementProperty> methodParameters) {
        this.methodParameters = methodParameters;
    }

    public DocumentElementProperty getReturnType() {
        return returnType;
    }

    public void setReturnType(DocumentElementProperty returnType) {
        this.returnType = returnType;
    }
}
