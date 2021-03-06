/*
 * Copyright 2013 (c) MuleSoft, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific
 * language governing permissions and limitations under the License.
 */
package org.raml.parser.resolver;

import java.util.Arrays;
import java.util.List;

import org.raml.parser.completion.KeySuggestion;
import org.raml.parser.completion.Suggestion;
import org.yaml.snakeyaml.nodes.NodeTuple;
import org.yaml.snakeyaml.nodes.ScalarNode;

public class MimeTypeHandler implements TupleHandler
{

    @Override
    public boolean handles(NodeTuple tuple)
    {
        if (tuple.getKeyNode() instanceof ScalarNode)
        {
            ScalarNode keyNode = (ScalarNode) tuple.getKeyNode();
            return keyNode.getValue().contains("/");
        }
        else
        {
            return false;
        }
    }

    @Override
    public List<Suggestion> getSuggestions()
    {
        KeySuggestion[] suggestions = {
            new KeySuggestion("application/json"),
            new KeySuggestion("application/xml"),
            new KeySuggestion("application/x-www-form-urlencoded"),
            new KeySuggestion("multipart/form-data")
        };
        return Arrays.<Suggestion>asList(suggestions);
    }

}
