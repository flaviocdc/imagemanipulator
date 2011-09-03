/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package br.ufrj.dcc.compgraf.im.ui.file;

import java.io.File;
import java.util.Set;
import java.util.TreeSet;

import javax.imageio.ImageIO;
import javax.swing.filechooser.FileFilter;

public class ImageFilter extends FileFilter
{

  public boolean accept(File f)
  {
    if (f.isDirectory())
    {
      return true;
    }

    Set<String> supportedFormats = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
    for (String format : ImageIO.getReaderFileSuffixes())
    {
      supportedFormats.add(format.toLowerCase());
    }

    String extension = extractExtension(f);

    if (extension != null)
    {
      return supportedFormats.contains(extension);
    }
    else
    {
      return false;
    }
  }

  private String extractExtension(File f)
  {
    if (f.getAbsolutePath().lastIndexOf('.') == -1)
      return null;

    return f.getAbsolutePath().substring(f.getAbsolutePath().lastIndexOf('.') + 1);
  }

  // The description of this filter
  public String getDescription()
  {
    StringBuffer sb = new StringBuffer();
    for (String format : ImageIO.getReaderFileSuffixes())
    {
      sb.append("*.").append(format).append(", ");
    }

    return sb.delete(sb.length() - 2, sb.length() - 1).toString();
  }
}