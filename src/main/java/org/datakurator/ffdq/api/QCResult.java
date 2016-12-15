package org.datakurator.ffdq.api;

import java.util.Map;

/**
 * Created by lowery on 12/14/16.
 */
public interface QCResult {
    String getComment();
    QCResultState getResultState();
    Map<String, String> getResult(String key);
}
