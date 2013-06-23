/**
 * This file is part of Words With Crosses.
 *
 * Copyright (C) 2013 Adam Rosenfield
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.adamrosenfield.wordswithcrosses.net;

import android.annotation.TargetApi;
import android.app.DownloadManager;

@TargetApi(11)
public class DownloadReceiverHoneycomb extends DownloadReceiverGinger
{
    @Override
    protected boolean isMimeTypeXCrossword(DownloadManager manager, long downloadId)
    {
        String mimeType = manager.getMimeTypeForDownloadedFile(downloadId);
        if ("application/x-crossword".equals(mimeType))
        {
            return true;
        }
        else
        {
            LOG.warning("Bad mime type for downloaded file: " + mimeType);
            return false;
        }
    }
}
