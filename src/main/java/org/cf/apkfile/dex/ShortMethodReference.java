package org.cf.apkfile.dex;

import com.google.common.base.Objects;
import org.jf.dexlib2.iface.reference.MethodReference;

import javax.annotation.Nonnull;
import java.util.List;

public class ShortMethodReference implements MethodReference {

    private final MethodReference methodRef;
    private final String shortSignature;

    ShortMethodReference(MethodReference methodRef) {
        this.methodRef = methodRef;
        String fullSignature = methodRef.toString();
        int leftParensIndex = fullSignature.indexOf('(');
        shortSignature = fullSignature.substring(0, leftParensIndex);
    }

    @Override
    public int compareTo(@Nonnull MethodReference o) {
        String signature = o.toString();
        return shortSignature.compareTo(signature);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        ShortMethodReference other = (ShortMethodReference) obj;
        return Objects.equal(this.shortSignature, other.shortSignature);
    }

    @Nonnull
    @Override
    public String getDefiningClass() {
        return methodRef.getDefiningClass();
    }

    @Nonnull
    @Override
    public String getName() {
        return methodRef.getName();
    }

    @Nonnull
    @Override
    public List<? extends CharSequence> getParameterTypes() {
        return methodRef.getParameterTypes();
    }

    @Nonnull
    @Override
    public String getReturnType() {
        return methodRef.getReturnType();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(shortSignature);
    }

    @Override
    public String toString() {
        return shortSignature;
    }

}
