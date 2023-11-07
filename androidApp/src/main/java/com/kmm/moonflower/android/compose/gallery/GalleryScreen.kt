package com.kmm.moonflower.android.compose.gallery

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.PagingData
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.kmm.moonflower.android.compose.plantlist.PhotoListItem
import com.kmm.moonflower.android.R
import com.kmm.moonflower.android.data.UnsplashPhoto
import com.kmm.moonflower.android.data.UnsplashPhotoUrls
import com.kmm.moonflower.android.data.UnsplashUser
import com.kmm.moonflower.android.viewmodels.GalleryViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

@Composable
fun GalleryScreen(
    viewModel: GalleryViewModel = hiltViewModel(),
    onPhotoClick: (UnsplashPhoto) -> Unit,
    onUpClick: () -> Unit,
) {
    GalleryScreen(
        plantPictures = viewModel.plantPictures,
        onPhotoClick = onPhotoClick,
        onUpClick = onUpClick,
    )
}

@Composable
private fun GalleryScreen(
    plantPictures: Flow<PagingData<UnsplashPhoto>>,
    onPhotoClick: (UnsplashPhoto) -> Unit = {},
    onUpClick: () -> Unit = {},
) {
    Scaffold(
        topBar = {
            GalleryTopBar(onUpClick = onUpClick)
        },
    ) { padding ->
        val pagingItems: LazyPagingItems<UnsplashPhoto> = plantPictures.collectAsLazyPagingItems()
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.padding(padding),
            contentPadding = PaddingValues(all = dimensionResource(id = R.dimen.card_side_margin))
        ) {
            // TODO update this implementation once paging Compose supports LazyGridScope
            // See: https://issuetracker.google.com/issues/178087310
            items(
                count = pagingItems.itemCount,
                key = { index ->
                    val photo = pagingItems[index]
                    photo?.id ?: ""
                }
            ) { index ->
                val photo = pagingItems[index] ?: return@items
                PhotoListItem(photo = photo) {
                    onPhotoClick(photo)
                }
            }
        }
    }
}

@Composable
private fun GalleryTopBar(
    onUpClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    TopAppBar(
        title = {
            Text(stringResource(id = R.string.gallery_title))
        },
        modifier = modifier.statusBarsPadding(),
        navigationIcon = {
            IconButton(onClick = onUpClick) {
                Icon(
                    Icons.Filled.ArrowBack,
                    contentDescription = null
                )
            }
        },
    )
}

@Preview
@Composable
private fun GalleryScreenPreview(
    @PreviewParameter(GalleryScreenPreviewParamProvider::class) plantPictures: Flow<PagingData<UnsplashPhoto>>
) {
    GalleryScreen(plantPictures = plantPictures)
}

private class GalleryScreenPreviewParamProvider :
    PreviewParameterProvider<Flow<PagingData<UnsplashPhoto>>> {

    override val values: Sequence<Flow<PagingData<UnsplashPhoto>>> =
        sequenceOf(
            flowOf(
                PagingData.from(
                    listOf(
                        UnsplashPhoto(
                            id = "1",
                            urls = UnsplashPhotoUrls("https://images.unsplash.com/photo-1417325384643-aac51acc9e5d?q=75&fm=jpg&w=400&fit=max"),
                            user = UnsplashUser("John Smith", "johnsmith")
                        ),
                        UnsplashPhoto(
                            id = "2",
                            urls = UnsplashPhotoUrls("https://images.unsplash.com/photo-1417325384643-aac51acc9e5d?q=75&fm=jpg&w=400&fit=max"),
                            user = UnsplashUser("Sally Smith", "sallysmith")
                        )
                    )
                )
            ),
        )
}